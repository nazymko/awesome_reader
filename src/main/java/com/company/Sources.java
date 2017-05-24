package com.company;

/**
 * Created by nazymko on 24.05.2017.
 */
public enum Sources {
    JAVASCRIPT("https://raw.githubusercontent.com/sorrycc/awesome-javascript/master/README.md", "Javascript"),
    JAVASCRIPT_PROMISES("https://raw.githubusercontent.com/wbinnssmith/awesome-promises/master/README.md", "Javascript Promises"),
    NODEJS("https://raw.githubusercontent.com/sindresorhus/awesome-nodejs/master/readme.md", "Node.js"),
    SWIFT("https://raw.githubusercontent.com/matteocrippa/awesome-swift/master/README.md", "Swift"),
    PYTHON("https://raw.githubusercontent.com/vinta/awesome-python/master/README.md", "Python", "##"),
    RUST("https://raw.githubusercontent.com/rust-unofficial/awesome-rust/master/README.md", "Rust"),
    HASKELL("https://raw.githubusercontent.com/krispo/awesome-haskell/master/README.md", "Haskell", "##"),
    PURESCRIPT("https://raw.githubusercontent.com/passy/awesome-purescript/master/readme.md", "purescript", "##"),
    GO("https://raw.githubusercontent.com/avelino/awesome-go/master/README.md", "Go", "##"),
    SCALA("https://raw.githubusercontent.com/lauris/awesome-scala/master/README.md", "Scala", "##"),
    RUBY("https://raw.githubusercontent.com/markets/awesome-ruby/master/README.md", "Ruby", "##"),
    CLOJURE("https://raw.githubusercontent.com/razum2um/awesome-clojure/master/README.md", "Clojure", "##"),
    CLOJURESCRIPT("https://raw.githubusercontent.com/hantuzun/awesome-clojurescript/master/README.md", "ClojureScript"),
    ELIXIR("https://raw.githubusercontent.com/h4cc/awesome-elixir/master/README.md", "Elixir", "##"),
    ELM("https://raw.githubusercontent.com/isRuslan/awesome-elm/master/README.md", "Elm", "##"),
    ERLANG("https://raw.githubusercontent.com/drobakowski/awesome-erlang/master/README.md", "Erlang", "##"),
    LUA("https://raw.githubusercontent.com/LewisJEllis/awesome-lua/master/readme.md", "Lua"),
    C("https://raw.githubusercontent.com/aleksandar-todorovic/awesome-c/master/README.md", "C"),
    CPLUSPLUS("https://raw.githubusercontent.com/fffaraz/awesome-cpp/master/README.md", "C++", "##"),
    R("https://raw.githubusercontent.com/qinwf/awesome-R/master/README.md", "R", "##"),
    D("https://raw.githubusercontent.com/zhaopuming/awesome-d/master/README.md", "D", "##"),
    LISP("https://raw.githubusercontent.com/CodyReichert/awesome-cl/master/README.md", "Lisp", "##"),
    PERL("https://raw.githubusercontent.com/hachiojipm/awesome-perl/master/README.md", "Perl", "##"),
    GROOVY("https://raw.githubusercontent.com/kdabir/awesome-groovy/master/README.md", "Groovy", "##"),
    DART("https://raw.githubusercontent.com/yissachar/awesome-dart/master/README.md", "Dart", "##"),
    JAVA("https://raw.githubusercontent.com/akullpp/awesome-java/master/README.md", "Java", "##"),
    JAVA_RX("https://raw.githubusercontent.com/eleventigers/awesome-rxjava/master/README.md", "Java RX", "##"),
    OCAML("https://raw.githubusercontent.com/rizo/awesome-ocaml/master/README.md", "OCaml", "##"),
    COLDFUSION("https://raw.githubusercontent.com/seancoyne/awesome-coldfusion/master/README.md", "ColdFusion", "##"),
    FORTRAN("https://raw.githubusercontent.com/rabbiabram/awesome-fortran/master/README.md", "Fortran", "##"),
    DOTNET("https://raw.githubusercontent.com/quozd/awesome-dotnet/master/README.md", "dotNet", "##"),
    PHP("https://raw.githubusercontent.com/ziadoz/awesome-php/master/README.md", "PHP", "##"),
    PHP_COMPOSER("https://raw.githubusercontent.com/jakoch/awesome-composer/master/README.md", "Composer(PHP)", "##"),
    DELPHI("https://raw.githubusercontent.com/Fr0sT-Brutal/awesome-delphi/master/README.md", "Delphi", "##"),
    AUTOIT("https://raw.githubusercontent.com/J2TeaM/awesome-AutoIt/master/README.md", "Delphi"),
    CRYSTAL("https://raw.githubusercontent.com/veelenga/awesome-crystal/master/README.md", "Crystal", "##"),
    TYPESCRIPT("https://raw.githubusercontent.com/dzharii/awesome-typescript/master/README.md", "TypeScript", "##"),
    FREGE("https://raw.githubusercontent.com/sfischer13/awesome-frege/master/README.md", "Frege"),



//    CMAKE("https://raw.githubusercontent.com/onqtam/awesome-cmake/master/README.md", "cmake"),
//    https://raw.githubusercontent.com/KotlinBy/awesome-kotlin/master/README.md  ??

    ;


    private final String url;
    private final String name;
    private String chapter;

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public String getChapter() {
        return chapter;
    }

    Sources(String url, String name, String chapter) {

        this.url = url;
        this.name = name;
        this.chapter = chapter;
    }

    Sources(String url, String name) {
        this.url = url;
        this.name = name;
        this.chapter = "###";
    }
}
