package rocket.app.view;

import eNums.eAction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import rocket.app.MainApp;
import rocketCode.Action;
import rocketData.LoanRequest;

public class MortgageController {

	@FXML TextField txtCreditScore;
	@FXML TextField txtMortgageAmt;
	@FXML TextField txtIncome;
	@FXML TextField txtExpenses;
	@FXML TextField txtHouseCost;
	@FXML ComboBox cmbTerm;
	@FXML Label lblMortgagePayment;
	@FXML Label lblCreditScore;
	@FXML Label lblTerm;
	@FXML Label lblIncome;
	
	private TextField txtNew;
	
	private MainApp mainApp;
	

	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
	}
	
	
	@FXML
	public void btnCalculatePayment(ActionEvent event)
	{
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Message Here...");
		alert.setHeaderText("Look, an Information Dialog");
		alert.setContentText(txtNew.getText());
		alert.showAndWait().ifPresent(rs -> {
		    if (rs == ButtonType.OK) {
		        System.out.println("Pressed OK.");
		    }
		});
	}
	
	public void HandleLoanRequestDetails(LoanRequest lRequest)
	{
		
		double PITI1 = lRequest.getdIncome() * 0.28;
		double PITI2 = lRequest.getdIncome() * 0.36 - lRequest.getdExpense();
		if(PITI1>=PITI2){
			if(PITI2>=lRequest.getdPayment()){;
				txtMortgageAmt.setText("The MortgageAmt will Be: $ %,.2f");
			}
			else if (PITI2<lRequest.getdPayment()){
				txtMortgageAmt.setText("House Cost too High");
			}
		}
		else if (PITI1<PITI2){
			if(PITI1>=lRequest.getdPayment()){
				txtMortgageAmt.setText("The MortgageAmt will Be: $ %,.2f");
			}
			else if (PITI1<lRequest.getdPayment()){
				txtMortgageAmt.setText("House Cost too High");
			}
		}
		}
		
}
