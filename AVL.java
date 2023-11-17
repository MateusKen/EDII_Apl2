public class AVL extends BinaryTree{
	
  public NoAVL raiz;
  private int nElem;   // N�mero de elementos (n�s) na �rvore

  public AVL()  { raiz = null;  nElem=0; }

  public AVL(String e){
    raiz = new NoAVL(e, 0, null, null, null );
    nElem = 1;
  }

  public NoAVL getNoRaiz(){ 
	  return raiz; 
  }
  
  private int calculaAlturaAVL(){
  	int cont = -1;
  	if (!isEmpty()){
  		
  	}
  	return cont;
  }

  private void setNoRaiz(NoAVL novoNoRaiz){
  	raiz = novoNoRaiz;
  }

  public int getNElem(){ return nElem; }
  public void setNElem(int nElem){ this.nElem = nElem; }

  public boolean isEmpty(){
    if (raiz == null)
      return true;
    else
      return false;
  }

  public NoAVL searchAVL( String e ){
    return searchNoAVL(raiz, e);
  }
  
  private NoAVL searchNoAVL( NoAVL noAtual, String e ){
    NoAVL aux;
    if (noAtual != null) {
      if (noAtual.getElement().compareTo( e ) == 0) // Se elemento encontrado
        return noAtual;
      else{ // Se n�o encontrado, busca primeiro do lado esquerdo
        aux = searchNoAVL( noAtual.getSubEsq(), e );
        if (aux == null)  // Procura do lado direito da �rvore
          aux = searchNoAVL( noAtual.getSubDir(), e );
        return aux;
      }
    } else // Elemento �dado� n�o encontrado na �rvore
      return null;
  }



  public void emOrdemSimetrica( NoAVL raiz ){
    if (raiz != null){
      emOrdemSimetrica( raiz.getSubEsq() );
      System.out.println( raiz.getElement() );
      emOrdemSimetrica( raiz.getSubDir() );
    }
  }

  public void preOrdem( NoAVL raiz ){
    if (raiz != null){
      System.out.println( raiz.getElement() );
      preOrdem( raiz.getSubEsq() );
      preOrdem( raiz.getSubDir() );
    }
  }

  public void posOrdem( NoAVL raiz ){
    if (raiz != null){
      posOrdem( raiz.getSubEsq() );
      posOrdem( raiz.getSubDir() );
      System.out.println( raiz.getElement() );
    }
  }

 


  /* rota��o tipo LL */
  private NoAVL rotacaoLL(NoAVL desbA)
  {
   NoAVL aux;

   aux = desbA.getSubEsq();
   if (desbA.getPai() != null){   /* verifica se desb n�o � a raiz */
      if (desbA.getPai().getSubEsq() == desbA)
          desbA.getPai().setSubEsq( aux );
        else
         desbA.getPai().setSubDir( aux );
   }

    aux.setPai( desbA.getPai() );
    desbA.setSubEsq( aux.getSubDir() );

    if (desbA.getSubEsq() != null)
       desbA.getSubEsq().setPai( desbA );

    aux.setSubDir( desbA );
    desbA.setPai( aux );

    return( aux );
  }

/* rota��o tipo RR */
private NoAVL rotacaoRR(NoAVL desbA)
{
  NoAVL aux;

  aux = desbA.getSubDir();
  if (desbA.getPai() != null)   /* verifica se desb n�o � a raiz */
     if (desbA.getPai().getSubEsq() == desbA)
        desbA.getPai().setSubEsq( aux );
     else
        desbA.getPai().setSubDir( aux );

  aux.setPai( desbA.getPai() );
  desbA.setSubDir( aux.getSubEsq() );
  if (desbA.getSubDir() != null)
     desbA.getSubDir().setPai( desbA );
  aux.setSubEsq( desbA );
  desbA.setPai( aux );

  return(aux);
}


/* rota��o tipo LR */
private NoAVL rotacaoLR(NoAVL desbA)
{
  desbA.setSubEsq ( rotacaoRR( desbA.getSubEsq() ) );
  return( rotacaoLL(desbA) );
}


/* rota��o tipo RL */
private NoAVL rotacaoRL(NoAVL desbA)
{
  desbA.setSubDir( rotacaoLL( desbA.getSubDir() ) );
  return( rotacaoRR(desbA) );
}

private boolean flagInsercao;

public void insereAVL(String k)
{
  flagInsercao = false;
  setNoRaiz( insereNoAVL(raiz, k));
  setNElem( getNElem() + 1 );
}

public NoAVL insereNoAVL(NoAVL noAtual, String x )
{
  if (noAtual != null)
  {
    if (noAtual.getElement().compareTo( x ) > 0)
    {
      noAtual.setSubEsq( insereNoAVL( noAtual.getSubEsq(), x ) );
      noAtual.getSubEsq().setPai( noAtual );
      if (flagInsercao)
      {
        switch( noAtual.getFb() ){
           case -1: noAtual.setFb( 0 );
                   flagInsercao = false;
                   break;
           case 0: noAtual.setFb( 1 );
                   break;
           case 1: if (noAtual.getSubEsq().getFb() == 1)
                    {
                      noAtual = rotacaoLL(noAtual);
                      //Arrumando os fatores ap�s a rota��o
                      noAtual.setFb( 0 );
                      noAtual.getSubDir().setFb( 0 );
                    }
                    else
                    {
                      noAtual = rotacaoLR(noAtual);
                      //Arrumando os fatores ap�s a rota��o
                      if (noAtual.getFb()==0)
                      { //1�Caso
                        noAtual.getSubDir().setFb( 0 );
                        noAtual.getSubEsq().setFb( 0 );
                      }
                      else if (noAtual.getFb() == 1)
                      { //2�Caso
                        noAtual.getSubEsq().setFb( 0 );
                        noAtual.getSubDir().setFb( -1 );
                      }
                      else
                      { //3�Caso
                        noAtual.getSubEsq().setFb( 1 );
                        noAtual.getSubDir().setFb( 0 );
                      }
                      noAtual.setFb(0);
                    }
                    flagInsercao = false;
                    break;
        }
      }
    }
    else
    {
      noAtual.setSubDir( insereNoAVL(noAtual.getSubDir(), x));
      noAtual.getSubDir().setPai( noAtual );
      if ( flagInsercao )
      {
        switch( noAtual.getFb() ){
           case -1: if (noAtual.getSubDir().getFb() == -1)
                    {
                      noAtual = rotacaoRR(noAtual);
                      //Arrumando os fatores ap�s a rota��o
                      noAtual.setFb(0);
                      noAtual.getSubEsq().setFb(0);
                    }
                    else
                    {
                      noAtual = rotacaoRL(noAtual);
                      //Arrumando os fatores ap�s a rota��o
                      if (noAtual.getFb()==0)
                      { //1�Caso
                        noAtual.getSubDir().setFb(0);
                        noAtual.getSubEsq().setFb(0);
                      }
                      else if (noAtual.getFb() == -1)
                      { //2�Caso
                        noAtual.getSubDir().setFb(0);
                        noAtual.getSubEsq().setFb(-1);
                      }
                      else
                      { //3�Caso
                        noAtual.getSubDir().setFb( -1 );
                        noAtual.getSubEsq().setFb( 0 );
                      }
                      noAtual.setFb(0);
                    }
                    flagInsercao = false;
                   break;
           case 0: noAtual.setFb(-1);
                   break;
           case 1: noAtual.setFb(0); 
                   flagInsercao=false;
                   break;
         }
       }
    }
 }
 else
 {
    noAtual = new NoAVL( x, 0, null, null, null );

    flagInsercao = true;
 }
 return( noAtual );
}


private boolean flagRemove;
    
    public boolean removeAVL(String k){
        flagRemove=false;
        if (raiz == null) {
            System.out.println("Erro na remo��o, a �rvore est� vazia !");
            return false;
        }
        else if (searchAVL(k)==null){
            System.out.println("Erro na remo��o, elemento n�o existente !");
            return false;
        }
        else {
            raiz = removeNoAVL(raiz, k);
            setNElem( getNElem() - 1 );
            return true;
        }
    }

    private NoAVL removeNoAVL(NoAVL noAtual, String x){
        if (noAtual.getElement().compareTo( x ) > 0){
            noAtual.setSubEsq(removeNoAVL(noAtual.getSubEsq(),x));
            if (flagRemove)
                noAtual = balanceamentoEsquerdo(noAtual);
        }
        else if (noAtual.getElement().compareTo(x)<0){
            noAtual.setSubDir(removeNoAVL(noAtual.getSubDir(),x));
            if (flagRemove)
                noAtual = balanceamentoDireito(noAtual);
        }
        else { //Encontrou o n� a ser removido
            if (noAtual.getSubDir()==null){
                if (noAtual.getSubEsq()!=null){ //Escolhe o n� � esquerda como substituto
                    noAtual.getSubEsq().setPai(noAtual.getPai());
                }
                noAtual = noAtual.getSubEsq();
                flagRemove = true;
            }
            else if (noAtual.getSubEsq()==null){
                if (noAtual.getSubDir()!=null){ //Escolhe o n� � direita como substituto
                    noAtual.getSubDir().setPai(noAtual.getPai());
                }
                noAtual = noAtual.getSubDir();
                flagRemove = true;
            }
            else{ // Busca o elemento mais � direita do n� esquerdo
                noAtual.setSubEsq(buscaRemove(noAtual.getSubEsq(), noAtual));
                //Se necess�rio efetua balanceamento (Esquerdo pois a fun��o 
                //busca_remove foi para o n� esquerdo)
                if (flagRemove){
                    noAtual = balanceamentoEsquerdo(noAtual);
                }
            }
        }
        
        return noAtual;
    }
 
    private NoAVL balanceamentoEsquerdo (NoAVL no){
        switch (no.getFb()){
            case 1:
                no.setFb(0);
                break;
            case 0:
                no.setFb(-1);
                flagRemove=false;
                break;
            case -1:
                NoAVL subDir = no.getSubDir();
                int fb = subDir.getFb();
                if (fb<=0){
                    subDir = rotacaoRR(no);
                    if (fb == 0){
                        no.setFb(-1);
                        subDir.setFb(1);
                        flagRemove = false;
                    }
                    else{
                        no.setFb(0);
                        subDir.setFb(0);
                    }
                    no = subDir;
                }
                else{
                    no = rotacaoRL(no);
                    if (no.getFb( )==0){
                  		no.getSubDir().setFb(0); no.getSubEsq().setFb(0);}
             		else if (no.getFb( )==-1){ no.setFb(0); 
                  		no.getSubDir().setFb(0); no.getSubEsq().setFb(1);}
             		else {no.setFb(0); 
                  		no.getSubDir().setFb(-1); no.getSubEsq().setFb(0);} 
                }
        }
        return (no);
    }
    
    private NoAVL balanceamentoDireito (NoAVL no){
        switch (no.getFb()){
            case -1:
                no.setFb(0);
                break;
            case 0:
                no.setFb(1);
                flagRemove=false;
                break;
            case 1:
                NoAVL subEsq = no.getSubEsq();
                int fb = subEsq.getFb();
                if (fb>=0){
                    subEsq = rotacaoLL(no);
                    if (fb == 0){
                        no.setFb(1);
                        subEsq.setFb(-1);
                        flagRemove = false;
                    }
                    else{
                        no.setFb(0);
                        subEsq.setFb(0);
                    }
                    no = subEsq;
                }
                else{
                    no = rotacaoLR(no);
                    if (no.getFb( )==0){
                  		no.getSubDir().setFb(0); no.getSubEsq().setFb(0);}
             		else if (no.getFb( )==1){ no.setFb(0); 
                  		no.getSubDir().setFb(-1); no.getSubEsq().setFb(0);}
             		else {no.setFb(0); 
                  		no.getSubDir().setFb(0); no.getSubEsq().setFb(1);} 
                }
        }
        return (no);  
    }

    private NoAVL buscaRemove(NoAVL noAtual, NoAVL noChave){
        
        NoAVL noRemovido;
        if (noAtual.getSubDir()!=null){
            noAtual.setSubDir(buscaRemove(noAtual.getSubDir(), noChave));
            if (flagRemove){
                noAtual = balanceamentoDireito(noAtual);
            }
        }
        else{
            noChave.setElement(noAtual.getElement());
            noRemovido = noAtual;
            noAtual = noAtual.getSubEsq();
            if (noAtual != null){
                noAtual.setPai(noRemovido.getPai());
            }
            flagRemove = true;
            noRemovido = null;
        }
        return (noAtual);
        
    }

}
