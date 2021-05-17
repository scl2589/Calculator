package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controller {
    private String operator = "";
    private int x = 0;
    private Model model = new Model();

    @FXML
    private Text result;

    @FXML
    private void operand(ActionEvent event) {
        //event.getSource -> 이벤트를 발생시킨 정보 자체를 가져온다.
        result.setText(result.getText() + ((Button) event.getSource()).getText());
    }

    @FXML
    private void operator(ActionEvent event) {
        if (((Button) event.getSource()).getText().equals("=")) {
            if (operator.equals("/") && Integer.parseInt(result.getText()) == 0) {
                result.setText("Error");
            } else {
                result.setText(model.calculate(operator, x, Integer.parseInt(result.getText())) + "");
            }

        } else {
            operator = ((Button) event.getSource()).getText();
            x = Integer.parseInt(result.getText());
            result.setText("");
        }
    }

    @FXML
    private void clear(ActionEvent event) {
        result.setText("");
    }

    @FXML
    private void backspace(ActionEvent event) {
        String current = result.getText();
        if (current.length() >= 1) {
            result.setText(current.substring(0, current.length()-1));
        } else {
            result.setText("");
        }
    }
}
