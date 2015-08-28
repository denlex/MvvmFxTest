package org.defence.viewmodels;

import de.saxsys.mvvmfx.ViewModel;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by root on 8/28/15.
 */
public class BookViewModel implements ViewModel {
    private final StringProperty title = new SimpleStringProperty();
    private final StringProperty author = new SimpleStringProperty();
    private final IntegerProperty year = new SimpleIntegerProperty();

    public BookViewModel() {
    }

    public BookViewModel(String title, String author, int year) {
        this.title.setValue(title);
        this.author.setValue(author);
        this.year.setValue(year);
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getAuthor() {
        return author.get();
    }

    public StringProperty authorProperty() {
        return author;
    }

    public void setAuthor(String author) {
        this.author.set(author);
    }

    public int getYear() {
        return year.get();
    }

    public IntegerProperty yearProperty() {
        return year;
    }

    public void setYear(int year) {
        this.year.set(year);
    }
}
