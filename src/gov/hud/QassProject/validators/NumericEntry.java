package gov.hud.QassProject.validators;

import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.validator.ValidationException;
import com.opensymphony.xwork2.validator.validators.FieldValidatorSupport;

public class NumericEntry extends FieldValidatorSupport {

	@Override
	public void validate(Object field) throws ValidationException {
		String fieldName = getFieldName();
		String fieldValue = (String) getFieldValue(fieldName, field);
		
		
			if (isNumeric(fieldValue) == false){
				addFieldError(fieldName,field);
			}
		
	}
	
	public boolean isNumeric(String inputValue){
		
		 return StringUtils.isNumeric(inputValue) ;
	}

}
