public class NoAVL {
private String e;  // Elemento a ser armazenado 
private int fb;  // Fator de balanceamento
private NoAVL pai;  // Ponteiro para o pai do n�
private NoAVL subEsq;
private NoAVL subDir;
public NoAVL(){ this( "", 0, null, null, null); } 
public NoAVL(
String e, int fb, NoAVL pai, NoAVL subEsq, NoAVL subDir )
{ 
   this.e = e; this.fb = fb;
   this.pai = pai; this.subEsq = subEsq; 
   this.subDir = subDir; 
}
public String getElement(){ return e; }
public int getFb(){ return fb; }
public NoAVL getPai(){ return pai; }
public NoAVL getSubDir(){ return subDir; }
public NoAVL getSubEsq(){ return subEsq; }
public void setElement(String e){ this.e = e; }
public void setSubEsq(NoAVL subEsq){ this.subEsq = subEsq; }
public void setSubDir(NoAVL subDir) { this.subDir = subDir; }
public void setFb(int fb) { this.fb = fb; }
public void setPai(NoAVL pai) { this.pai = pai; }
}
