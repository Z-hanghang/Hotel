package common.gui;

import java.awt.GridBagConstraints;
import java.awt.Insets;

public class GBC extends GridBagConstraints {
  public GBC(int gridx, int gridy) {
    this.gridx = gridx;
    this.gridy = gridy;
  }
  
  public GBC(int gridx, int gridy, int gridwidth, int gridheight) {
    this(gridx, gridy);
    this.gridwidth = gridwidth;
    this.gridheight = gridheight;
  }
  
  public GBC setFill(int fill) {
    this.fill = fill;
    return this;
  }
  
  public GBC setInsets(Insets insets) {
    this.insets = insets;
    
    return this;
  }
  
  public GBC setWeightx(double weightx) {
    this.weightx = weightx;
    
    return this;
  }
  
  public GBC setWeighty(double weighty) {
    this.weighty = weighty;
    
    return this;
  }
}
