public class Carte{

  //attributs
  private int val;
  private boolean visible;

  //constructeurs
  Carte(){
    this.val = 0;
    this.visible = false;
  }

  Carte(int val, boolean visible){
    this.val = val;
    this.visible = visible;
  }

  //methodes
  public int getVal(){
    return this.val;
  }

  public void setVal(int symbole){
    this.val = val;
  }

  public boolean getVisible(){
    return this.visible;
  }

  public void setVisible(boolean visible){
    this.visible = visible;
  }

  public boolean equals(Object o){
    if (o == null || o.getClass() != this.getClass()){
      return false;
    }
    Carte c = (Carte) o;
    return c.getVal()==this.getVal() && c.getVisible() == this.getVisible();
  }
}
