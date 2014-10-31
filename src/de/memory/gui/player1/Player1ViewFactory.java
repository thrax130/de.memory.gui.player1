package de.memory.gui.player1;

import java.util.Properties;

import aQute.bnd.annotation.component.Component;
import de.memory.api.IMemoryModel;
import de.memory.api.IMemoryView;
import de.memory.api.IMemoryViewFactory;

@Component
public class Player1ViewFactory implements IMemoryViewFactory {

	private final Properties prop = new Properties();
	
	public Player1ViewFactory() {
		// TODO Auto-generated constructor stub
		prop.put("type", "player1");
	}
	
	@Override
	public IMemoryView createView(IMemoryModel model) {
		Player1View view = new Player1View();
		view.activate();
		model.addView(view);		
		return view;
	}

	@Override
	public Properties getProperties() {
		// TODO Auto-generated method stub
		return prop;
	}
	

}
