public class Carte{

  //ATTRIBUTS ceci est un test venant de Mme. SOLATGES lol prout
  private int val;
  private boolean visible;

  //CONSTRUCTEURS
  Carte(){
    this.val = -1;
    this.visible = false;
  }

  Carte(int val, boolean visible){
    this.val = val;
    this.visible = visible;
  }

  //METHODES
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
