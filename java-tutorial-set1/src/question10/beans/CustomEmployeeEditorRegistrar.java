package beans;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

public class CustomEmployeeEditorRegistrar implements PropertyEditorRegistrar{

	public void registerCustomEditors(PropertyEditorRegistry registry)
    {
        registry.registerCustomEditor(Date.class,
                new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
    }
	

}
