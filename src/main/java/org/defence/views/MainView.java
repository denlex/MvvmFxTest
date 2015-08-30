package org.defence.views;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;
import org.defence.viewmodels.BookViewModel;
import org.defence.viewmodels.MainViewModel;

/**
 * Created by root on 8/28/15.
 */
public class MainView implements FxmlView<MainViewModel> {
    @FXML
    private Label titleLabel;

    @FXML
    private Label authorLabel;

    @FXML
    private TextField titleTextField;

    @FXML
    private TextField authorTextField;

    @FXML
    private TextField yearTextField;

    @FXML
    private Button okButton;

    @FXML
    private Label descriptionLabel;

    /*@FXML
    private ListView<BookListItemViewModel> bookList;*/

    @FXML
    private Label errorLabel;

    @FXML
    private TableView<BookViewModel> bookTableView;

    @FXML
    private TableColumn<BookViewModel, String> titleTableColumn;

    @FXML
    private TableColumn<BookViewModel, String> authorTableColumn;

    @FXML
    private TableColumn<BookViewModel, Integer> yearTableColumn;

    @InjectViewModel
    private MainViewModel viewModel;

    public void initialize() {

        titleTableColumn.setCellValueFactory(new PropertyValueFactory("title"));
        authorTableColumn.setCellValueFactory(new PropertyValueFactory("author"));
        yearTableColumn.setCellValueFactory(new PropertyValueFactory("year"));

        titleTextField.textProperty().bindBidirectional(viewModel.title);
        authorTextField.textProperty().bindBidirectional(viewModel.author);
        yearTextField.textProperty().bindBidirectional(viewModel.year, new StringConverter<Number>() {
            @Override
            public String toString(Number object) {
                return object.toString();
            }

            @Override
            public Number fromString(String string) {
                return Integer.parseInt(string);
            }
        });

        bookTableView.itemsProperty().bindBidirectional(viewModel.books);
    }

    public void okButtonPressed() {
        viewModel.getOkCommand().execute();
        int lastRowIndex = viewModel.books.size() - 1;
        bookTableView.scrollTo(lastRowIndex);
        bookTableView.selectionModelProperty().get().select(lastRowIndex);
    }
}
