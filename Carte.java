public class Carte{

  //ATTRIBUTS ceci est un test venant de Mme. SOLATGES lol prout
  private int val;
  private boolean visible;
  private int[] coord = new int[2];

  //CONSTRUCTEURS
  Carte(){
    this.val = -1;
    this.visible = false;
    this.coord[0]=-1;
    this.coord[1]=-1;
  }

  Carte(int val, boolean visible, int x, int y){
    this.val = val;
    this.visible = visible;
    this.coord[0] = x;
    this.coord[1] = y;
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

  public int getX(){
    return this.coord[0];
  }

  public int getY(){
    return this.coord[1];
  }

  public void setCoord(int x, int y){
    this.coord[0] = x;
    this.coord[1] = y;
  }



  public boolean equals(Object o){
    if (o == null || o.getClass() != this.getClass()){
      return false;
    }
    Carte c = (Carte) o;
    return c.getVal()==this.getVal() && c.getVisible() == this.getVisible()
    && c.getX() == this.getX() && c.getY() == this.getY();
  }
}
