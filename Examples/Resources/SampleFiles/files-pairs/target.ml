open Ast_mapper
open Parsetree
open Longident
open Location

let ocaml_major, ocaml_minor =
  try
    Scanf.sscanf Sys.ocaml_version "%d.%d" (fun major minor -> major, minor)
  with Scanf.Scan_failure _ -> 2, 5

let substitute =
  { default_mapper with
    expr =
      begin fun mapper -> function

        | ({pexp_desc =
              Pexp_ident ({txt = Ldot (Lident "String", "capitalize_ascii"); _} as ident); _} as expr) when ocaml_major = 4 && ocaml_minor = 2 ->
          { expr with pexp_desc = Pexp_ident { ident with txt = Ldot (Lident "String", "capitalize")}}

        | ({pexp_desc =
              Pexp_ident ({txt = Ldot (Lident "Stdlib", smth); _} as ident); _} as expr)  when ocaml_major = 4 && ocaml_minor < 7 ->
          { expr with pexp_desc = Pexp_ident { ident with txt = Ldot (Lident "Pervasives", smth)}}

        | expr -> default_mapper.expr mapper expr
      end
  }

let mapper _ _ = substitute

let () =
  Migrate_parsetree.(Driver.register ~name:"compatibility" Versions.ocaml_404 mapper)