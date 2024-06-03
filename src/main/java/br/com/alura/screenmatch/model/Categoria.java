package br.com.alura.screenmatch.model;

public enum Categoria {
    ACAO("Action"),
    ROMANCE("Romance"),
    COMEDIA("Comedy"),
    DRAMA("Drama"),
    CRIME("Crime");

    private final String categoriaOmdb;

    Categoria(String categoriaOmdb){

        this.categoriaOmdb = categoriaOmdb;
    }

    public static Categoria fromString(String text){

        for (Categoria cat : Categoria.values()){

            if (cat.categoriaOmdb.equalsIgnoreCase(text)){

                return cat;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }


}
