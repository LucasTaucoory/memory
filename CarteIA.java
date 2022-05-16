public class CarteIA extends Carte{

  private int posx;
  private int posy;

CarteIA(){
  new Carte();
  this.posx = 0;
  this.posy = 0;
}

CarteIA( Carte carte, int x, int y){
  super();
  this.posx=x;
  this.posy = y;
}

public int getpositionx(){
  return this.posx;
}

public int getPositiony(){
  return this.posy;
}
public void setPositionx(int x){
  this.posx = x;
}

public void setPositiony(int y){
  this.posy = y;
}
}
