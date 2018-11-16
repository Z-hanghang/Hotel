package common.component.tools;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;

public class SetWindow {
	public static void setWindowCenter(Component cp) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		cp.setLocation (screenSize.width / 2 - (cp.getWidth() / 2), 
						screenSize.height / 2 - (cp.getHeight() / 2));
	}
	

}
