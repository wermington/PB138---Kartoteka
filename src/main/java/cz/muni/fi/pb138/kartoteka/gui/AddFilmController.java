package cz.muni.fi.pb138.kartoteka.gui;

import cz.muni.fi.pb138.kartoteka.entities.Film;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Add Film dialog controller
 *
 * @author Peter Stanko
 * @author Dominik Labuda
 * @author Peter Zaoral
 * @version 2015-06-06
 */
public class AddFilmController implements Initializable {

    /**
     * Current film
     */
    private Film film;

    /**
     * Main panel
     */
    @FXML
    private Parent root;

    /**
     * OK button
     */
    @FXML
    private Button okButton;

    /**
     * Cancel button
     */
    @FXML
    private Button cancelButton;

    /**
     * Text field for name
     */
    @FXML
    private TextField nameTextField;

    /**
     * Text field for year
     */
    @FXML
    private TextField yearTextField;

    /**
     * Text field for rating
     */
    @FXML
    private TextField ratingTextField;

    /**
     * Text field for director
     */
    @FXML
    private TextField directorTextField;

    /**
     * Text field for description
     */
    @FXML
    private TextField descriptionTextField;

    /**
     * Status label
     */
    @FXML
    private Label statusLabel;

    /**
     * Initializes the UI
     * @param location location
     * @param resources resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cancelButton.setCancelButton(true);
        okButton.setDefaultButton(true);

        cancelButton.setOnAction(event -> closeDialog());

        okButton.setOnAction(event -> {
                if(nameTextField.getText().isEmpty()) {
                    statusLabel.setText(resources.getString("dialog.film.empty_name"));
                    return;
                }

                if(!yearTextField.getText().matches("[0-9]+")) {
                    statusLabel.setText(resources.getString("dialog.film.year_wrong"));
                    return;
                }

                if (film == null) {
                    film = new Film();
                }
                film.setName(nameTextField.getText());
                film.setYear(yearTextField.getText());
                film.setRating(ratingTextField.getText());
                film.setDirector(directorTextField.getText());
                film.setDescription(descriptionTextField.getText());
                closeDialog();
            }
        );
    }

    /**
     * Getter for {@link AddFilmController#film}
     * @return film
     */
    public Film getFilm() {
        return film;
    }

    /**
     * Sets the {@link AddFilmController#film} and fills inputs
     * @param film film to be updated
     */
    public void updateSetUp(Film film) {
        this.film = film;
        nameTextField.setText(film.getName());
        yearTextField.setText(film.getYear());
        ratingTextField.setText(film.getRating());
        directorTextField.setText(film.getDirector());
        descriptionTextField.setText(film.getDescription());
    }

    /**
     * Closes dialog
     */
    private void closeDialog() {
        ((Stage) root.getScene().getWindow()).close();
    }
}
