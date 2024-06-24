package com.edinson.consumoapi.model;


///1 paso se crea  la clase
public class Pokemon {
    private String name;
    private String url;

//////constructor vacio
    public Pokemon() {
    }
///constructor

    public Pokemon(String name, String url) {
        this.name = name;
        this.url = url;
    }

///get y set

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


///tostring


    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
