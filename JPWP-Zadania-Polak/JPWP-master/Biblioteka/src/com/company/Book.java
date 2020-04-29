package com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Book {
    private List<Page> pages;
    private String author;
    private PagePrinter pagePrinter;
    private StringBuilder bookAsHtml;

    Book(){
        pagePrinter = new PagePrinter();
        bookAsHtml = new StringBuilder();
    }

    void printBookToHtml(Book book, String path)  {
        printPagesToHtml(book.getPages());
        print(path);
    }
    void print(String path) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(path);
            printWriter.write(bookAsHtml.toString());
            printWriter.close();
        }catch (IOException e){
            System.err.println(e.getLocalizedMessage());
        }finally {
            printWriter.close();
        }
    }

    private void printPagesToHtml(List<Page> pages){
        String bodyContent = pagePrinter.printPagesToHtml(pages);
        wrapBodyContent(bodyContent);
    }

    private void wrapBodyContent(String bodyContent){
        bookAsHtml.setLength(0);//make sure buffer is empty
        bookAsHtml.append("<html><head></head><body>");
        bookAsHtml.append(bodyContent);
        bookAsHtml.append("</body></html>");
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
