package com.company;

import java.util.List;

public class PagePrinter {
    private StringBuilder htmlContent;

    PagePrinter(){
        htmlContent = new StringBuilder();
    }

    String printPagesToHtml(List<Page> pages){
        pages.forEach(page ->{
            addPageToContent(page);
        });
        return htmlContent.toString();
    }

    private void addPageToContent(Page page){
        htmlContent.setLength(0);
        htmlContent.append("<div><p style='text-align: justify;'>");
        htmlContent.append(page.getContent());
        htmlContent.append("</p><p style='text-align: center;'>");
        htmlContent.append(page.getNumber());
        htmlContent.append("</p></div>");
    }
}
