open Typedtree

and binary_part =
  | Partial_structure of structure
  | Partial_structure_item of structure_item
  | Partial_expression of expression
  | Partial_pattern of pattern
  | Partial_class_expr of class_expr
  | Partial_signature of signature
  | Partial_signature_item of signature_item
  | Partial_module_type of module_type

type cmt_infos = {
  cmt_modname : string;
  cmt_annots : binary_annots;
  cmt_comments : (string * Location.t) list;
  cmt_args : string array;
  cmt_sourcefile : string option;
  cmt_builddir : string;
  cmt_loadpath : string list;
  cmt_source_digest : string option;
  cmt_initial_env : Env.t;
  cmt_imports : (string * Digest.t) list;
  cmt_interface_digest : Digest.t option;
  cmt_use_summaries : bool;
}

type error =
    Not_a_typedtree of string

exception Error of error

(** [read filename] opens filename, and extract both the cmi_infos, if
    it exists, and the cmt_infos, if it exists. Thus, it can be used
    with .cmi, .cmt and .cmti files.
    .cmti files always contain a cmi_infos at the beginning. .cmt files
    only contain a cmi_infos at the beginning if there is no associated
    .cmti file.
*)
val read : string -> Cmi_format.cmi_infos option * cmt_infos option

val read_cmt : string -> cmt_infos
val read_cmi : string -> Cmi_format.cmi_infos

(** [save_cmt modname filename binary_annots sourcefile initial_env sg]
    writes a cmt(i) file.  *)
val save_cmt :
  string ->  (* filename.cmt to generate *)
  string ->  (* module name *)
  binary_annots ->
  string option ->  (* source file *)
  Env.t -> (* initial env *)
  Types.signature option -> (* if a .cmi was generated,
                               the signature saved there *)
  unit

(* Miscellaneous functions *)

val read_magic_number : in_channel -> string

val add_saved_type : binary_part -> unit
val get_saved_types : unit -> binary_part list
val set_saved_types : binary_part list -> unit

