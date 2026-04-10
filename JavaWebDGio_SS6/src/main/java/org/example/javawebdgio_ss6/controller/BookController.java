
package org.example.javawebdgio_ss6.controller;
import org.example.javawebdgio_ss6.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

    private List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1L, "Java Core", "Nguyen Van A", "CNTT", 250000, "NXB A", 2022, "Hoc Java co ban"));
        books.add(new Book(2L, "Spring MVC", "Tran Van B", "CNTT", 320000, "NXB B", 2023, "Hoc Spring MVC"));
        books.add(new Book(3L, "Data Structure", "Le Van C", "CNTT", 450000, "NXB C", 2021, "Hoc cau truc du lieu"));

        return books;
    }

    @GetMapping("/books")
    public String listBooks(Model model) {
        model.addAttribute("books", getBooks());
        return "books/list";
    }


    @GetMapping("/books/{id}")
    public String bookDetail(@PathVariable("id") Long id, Model model) {
        Book selectedBook = null;
        for (Book book : getBooks()) {
            if (book.getId().equals(id)) {
                selectedBook = book;
                break;
            }
        }
        model.addAttribute("book", selectedBook);
        return "books/details";
    }
}