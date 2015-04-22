package org.sp.librairie.inventaire.action;

import com.opensymphony.xwork2.ActionSupport;
import org.sp.librairie.inventaire.model.Book;
import org.sp.librairie.inventaire.service.BookService;

import java.util.List;

/**
 * Created by varduhi on 12/27/2014.
 */
public class BasicSearchAction extends ActionSupport {

    private String searchWord;

    private BookService bookService;
    private List<Book> searchResults;

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    public String execute() {
        try {

                searchResults = bookService.search(searchWord);
                return SUCCESS;



        } catch (Exception e) {
            e.printStackTrace();
            return ActionResult.EXCEPTION;
        }

    }


    public String getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }

    public List<Book> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(List<Book> searchResults) {
        this.searchResults = searchResults;
    }

    @Override
    public void validate() {
        if(searchWord==null ||searchWord.trim().isEmpty()){
            addFieldError("searchWord","");
        }
    }
}
