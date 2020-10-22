/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete.controles;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author FP Mañana A
 */
public class ClasePrincipal extends Application{
    VBox v;
    Button btn_fichero;
    File fichero;
    Label lbl_mostrar;
    Button btn_varios;
    Label lbl_varios;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        v=new VBox(30);
        btn_fichero=new Button("Abrir fichero");
        btn_varios=new Button("Abrir varios ficheros");
        lbl_mostrar=new Label("");
        lbl_varios=new Label("");
        FileChooser fc = new FileChooser();
       
        btn_fichero.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                fc.setTitle("Abrir Fichero");
                
                fichero=fc.showOpenDialog(stage);
                if (fichero != null) {
                   lbl_mostrar.setText(fichero.getName());
                }else{
                    lbl_mostrar.setText("No hay ficheros seleccionado.");
                }
                
            }
            
            
        });
        btn_varios.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                fc.setTitle("Abrir varios ficeros");
                List<File> lista_fichero=fc.showOpenMultipleDialog(stage);
                ArrayList<String> lista_nombres=new ArrayList();
                
                if(lista_fichero==null){
                    lbl_varios.setText("No hay ficheros seleccionados.");
                }else{
                    for (File file : lista_fichero) {
                    lista_nombres.add(file.getName());
                    
                    }
                    lbl_varios.setText(lista_nombres.toString());
                    
                }
                
            }
        });
      
        v.getChildren().addAll(btn_fichero,btn_varios,lbl_mostrar,lbl_varios);
        Scene escena=new Scene(v,300,300);
        stage.setScene(escena);
        stage.show();
    }
    
}
