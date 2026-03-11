package main;

import office.Document;
import office.Excel;
import office.Word;

public class Main {

    public static void main(String[] args) {
        Document doc = new Word();
        doc.drucken();
    }
}
