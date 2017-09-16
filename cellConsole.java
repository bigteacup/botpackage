/*package botpackage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.StackPane;
import javafx.util.Callback;

public class cellConsole {



public cellConsole(){
	
}
/*
public void creerCell(String string){
		ObservableList<String> names = FXCollections.observableArrayList();
		names.add(string);
		ListView<String> listView = new ListView<String>(names);
		listView.setCellFactory(ComboBoxListCell.forListView(names));
}
}


final ListView<Integer> list = new ListView<>() ;
for (int index = 0; index < 3000; index++) {
//    list.getItems().add(index);
}
list.setCellFactory(new Callback<ListView<Integer>, ListCell<Integer>>() {
    private int created;

    public ListCell<Integer> call(ListView<Integer> p) {
        created++;
        System.out.println("=================Created " + created);
        return new ListCell<Integer>() {
            private int called;

            @Override
            protected void updateItem(Integer value, boolean empty) {
                final int cellIndex = created;
                called++;
                System.out.println("Called " + cellIndex + " " + called);
                super.updateItem(value, empty);
                final String text = (value == null || empty) ? null : String.valueOf(value);
                setText(text);
            }
        };
    }
});
final StackPane root = new StackPane();
root.getChildren().add(list);
final Scene scene = new Scene(root);
primaryStage.setTitle("ListView");
primaryStage.setWidth(500);
primaryStage.setHeight(500);
primaryStage.setScene(scene);
primaryStage.show();
}
*/