public class Carte{

  //attributs
  private int symbole;
  private boolean visible;

  //constructeurs
  Carte(){
    this.symbole = 0;
    this.visible = false;
  }

  Carte(int symbole, boolean visible){
    this.symbole = symbole;
    this.visible = visible;
  }

  //methodes
  public int getSymbole(){
    return this.symbole;
  }

  public void setSymbole(int symbole){
    this.symbole = symbole;
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
    return c.getSymbole()==this.getSymbole() && c.getVisible() == this.getVisible();
  }
}
