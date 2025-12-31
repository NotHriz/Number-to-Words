import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        Label title = new Label("NUMBER TO WORDS CONVERTER");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        title.setTextFill(Color.web("#2c3e50"));

        Label subtitle = new Label("Securely convert large integers to legal word format");
        subtitle.setTextFill(Color.web("#95a5a6"));


        TextField inputField = new TextField();
        inputField.setPromptText("Enter a number (e.g. 9223372036854775807)");
        inputField.setPrefHeight(45);
        inputField.setStyle("-fx-background-radius: 8; -fx-border-color: #dcdde1; -fx-border-radius: 8; -fx-padding: 10; -fx-font-size: 14px;");

        Button convertBtn = new Button("CONVERT NOW");
        convertBtn.setPrefWidth(Double.MAX_VALUE);
        convertBtn.setPrefHeight(45);
        convertBtn.setStyle("-fx-background-color: #27ae60; -fx-text-fill: white; -fx-font-weight: bold; -fx-background-radius: 8; -fx-cursor: hand;");


        TextArea resultDisplay = new TextArea();
        resultDisplay.setEditable(false);
        resultDisplay.setWrapText(true);
        resultDisplay.setPrefHeight(120);
        resultDisplay.setStyle("-fx-control-inner-background: #f8f9fa; -fx-font-family: 'Consolas'; -fx-border-color: #dcdde1; -fx-font-size: 14px;");

        Button copyBtn = new Button("Copy to Clipboard");
        copyBtn.setStyle("-fx-background-color: transparent; -fx-text-fill: #2980b9; -fx-border-color: #2980b9; -fx-border-radius: 5;");


        convertBtn.setOnAction(e -> {
            String rawText = inputField.getText().trim();


            if (!rawText.matches("-?\\d+")) {
                resultDisplay.setText("ERROR: Invalid input. Please enter numbers only (no letters or special characters).");
                resultDisplay.setStyle("-fx-text-fill: #e74c3c; -fx-control-inner-background: #f8f9fa;");
                return;
            }

            try {
                long number = Long.parseLong(rawText);
                resultDisplay.setStyle("-fx-text-fill: black; -fx-control-inner-background: #f8f9fa;"); // Reset color

                if (number == 0) {
                    resultDisplay.setText("ZERO");
                    return;
                }

                boolean isNegative = number < 0;
                long absNumber = Math.abs(number);

                Stack stack = SplitIntoThousand.splitIntoThousand(absNumber);

                StringBuilder result = new StringBuilder();
                if (isNegative) result.append("NEGATIVE ");

                String[] scales = {"", "THOUSAND", "MILLION", "BILLION", "TRILLION", "QUADRILLION", "QUINTILLION"};

                while (!stack.isEmpty()) {
                    int currentScale = stack.size - 1;
                    int group = stack.pop();

                    if (group != 0) {
                        String words = ThreeDigitConversion.convertThreeDigits(group);
                        result.append(words.toUpperCase()).append(" ").append(scales[currentScale]).append(" ");
                    }
                }
                resultDisplay.setText(result.toString().trim());

            } catch (NumberFormatException ex) {
                resultDisplay.setText("ERROR: The number entered is too large for the system to process.");
            }
        });

        copyBtn.setOnAction(e -> {
            final Clipboard clipboard = Clipboard.getSystemClipboard();
            final ClipboardContent content = new ClipboardContent();
            content.putString(resultDisplay.getText());
            clipboard.setContent(content);
        });


        VBox container = new VBox(15, title, subtitle, inputField, convertBtn, resultDisplay, copyBtn);
        container.setPadding(new Insets(40));
        container.setAlignment(Pos.CENTER_LEFT);
        container.setStyle("-fx-background-color: white; -fx-background-radius: 15;");

        StackPane root = new StackPane(container);
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: #eef2f3;");

        Scene scene = new Scene(root, 600, 500);
        stage.setTitle("NumberToWords Dashboard v25.0.1");
        stage.setScene(scene);
        stage.show();
    }
}
