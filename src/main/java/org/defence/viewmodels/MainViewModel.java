package org.defence.viewmodels;

import com.sun.javafx.collections.ObservableListWrapper;
import de.saxsys.mvvmfx.ViewModel;
import de.saxsys.mvvmfx.utils.commands.Action;
import de.saxsys.mvvmfx.utils.commands.Command;
import de.saxsys.mvvmfx.utils.commands.DelegateCommand;
import javafx.beans.property.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by root on 8/28/15.
 */
public class MainViewModel implements ViewModel {

    public final ListProperty<BookViewModel> books;
    public final StringProperty title = new SimpleStringProperty();
    public final StringProperty author = new SimpleStringProperty();
    public final IntegerProperty year = new SimpleIntegerProperty();

    public Command getOkCommand() {
        return okCommand;
    }

    Command okCommand;

    public MainViewModel() {
        List<BookViewModel> bookViewModels = new ArrayList<>();
        bookViewModels.add(new BookViewModel("Война и мир", "Л.Толстой", 1983));
        bookViewModels.add(new BookViewModel("Евгений Онегин", "А.Пушкин", 1956));
        bookViewModels.add(new BookViewModel("Мцыри", "М.Лермонтов", 1960));

        books = new SimpleListProperty<>(new ObservableListWrapper<>(bookViewModels));

        okCommand = new DelegateCommand(() -> new Action() {

            @Override
            protected void action() throws Exception {
                books.add(new BookViewModel(title.getValue(), author.getValue(), year.getValue()));
            }
        });
    }
}
