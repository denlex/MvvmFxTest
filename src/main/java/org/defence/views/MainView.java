package org.defence.views;

import de.saxsys.mvvmfx.FxmlView;
import de.saxsys.mvvmfx.InjectViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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
    private TextField searchTextField;

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

    }

    public void okButtonPressed() {
        viewModel.getOkCommand().execute();
    }
}
