    def tools = new GroovyScriptEngine( '!' ).with {
        loadScriptByName( 'class.gvy' )
    }
    this.metaClass.mixin tools
    greet()