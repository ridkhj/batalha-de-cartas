# batalha-de-cartas
trabalho de paradigmas 

consiste em uma matriz 9x9 que é o tabuleiro dessa batalha, dois jogadores cada um com 5 cartas
participam dessa batalha. As cartas seguem o modelo abaixo

------- \n
|  5  |
|     | 
|7   6| 
|     |
|  7  | 
------- 

o jogador 1 tem cartas azuis
o jogador 2 tem cartas vermelhas 

em cada turno um jogador pode colocar apenas uma carta no campo de batalha 
se a carta colocada no turno atual for adjacente a outras cartas acontece a 
comparação de cartas (comparação feita de acordo com os numeros da carta modelo
acima), se a carta jogada tiver o numero maior que a adjacente acontece a dominação
(mudança de cor para a carta dominante).
