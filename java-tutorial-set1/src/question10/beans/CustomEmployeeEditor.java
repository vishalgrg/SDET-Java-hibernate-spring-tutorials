package beans;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.beans.PropertyChangeListener;
import java.beans.PropertyEditor;
import java.util.Date;

import org.springframework.beans.PropertyEditorRegistry;

public class CustomEmployeeEditor implements PropertyEditor {


	Class<?>        t;
    PropertyEditor  propertyEditor;

    public void CustomEditorRegistrar(Class<?> t, PropertyEditor propertyEditor)
    {
        this.t = t;
        this.propertyEditor = propertyEditor;
    }

    public void registerCustomEditors(PropertyEditorRegistry registry)
    {
        registry.registerCustomEditor(t, propertyEditor);
    }

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getAsText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Component getCustomEditor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getJavaInitializationString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getTags() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPaintable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void paintValue(Graphics gfx, Rectangle box) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValue(Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean supportsCustomEditor() {
		// TODO Auto-generated method stub
		return false;
	}

	

}
