package week3.third;

import java.util.StringTokenizer;

public class Address {
    private String country;
    private String region;
    private String city;
    private String street;
    private int house;
    private String corpus;
    private int flat;

    public Address(){}


    public void fromStrSplit(String str){
        String[] arr = str.split(",");
        this.country = arr[0].trim();
        this.region = arr[1].trim();
        this.city = arr[2].trim();
        this.street = arr[3].trim();
        this.house = Integer.parseInt(arr[4].trim());
        this.corpus = arr[5].trim();
        this.flat = Integer.parseInt(arr[6].trim());
    }

    public void fromStrToken(String str){
        StringTokenizer tok = new StringTokenizer(str, ",.;-");
        this.country = tok.nextToken().trim();
        this.region = tok.nextToken().trim();
        this.city = tok.nextToken().trim();
        this.street = tok.nextToken().trim();
        this.house = Integer.parseInt(tok.nextToken().trim());
        this.corpus = tok.nextToken().trim();
        this.flat = Integer.parseInt(tok.nextToken().trim());
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house=" + house +
                ", corpus='" + corpus + '\'' +
                ", flat=" + flat +
                '}';
    }
}