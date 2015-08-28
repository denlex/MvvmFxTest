package org.defence; /**
 * Created by root on 8/28/15.
 */

import com.guigarage.flatterfx.FlatterFX;
import com.guigarage.flatterfx.FlatterInputType;
import de.saxsys.mvvmfx.FluentViewLoader;
import de.saxsys.mvvmfx.ViewTuple;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.defence.viewmodels.MainViewModel;
import org.defence.views.MainView;

//https://github.com/sialcasa/mvvmFX/tree/develop/examples/books-example

public class MainApp extends Application {

//    private EasyDI context = new EasyDI();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
//        MvvmFX.setCustomDependencyInjector(type -> context.getInstance(type));

        primaryStage.setTitle("Library JavaFX");
        primaryStage.setMinWidth(1200);
        primaryStage.setMaxWidth(1200);
        primaryStage.setMinHeight(700);

        ViewTuple<MainView, MainViewModel> viewTuple = FluentViewLoader.fxmlView(MainView.class).load();

        Parent root = viewTuple.getView();
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);

        primaryStage.setScene(scene);
        primaryStage.show();

        FlatterFX.style(FlatterInputType.DEFAULT);
    }
}
