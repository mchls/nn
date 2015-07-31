
Doinstalovat: octave vcetne podpory grafu, gnuplot a g++

Pro octave je treba prelozit c programy:
cd  ~/pgms/michals/nn/jnn/stanford_dl_ex/common/minFunc_2012/minFunc/mex
mkoctfile --mex  lbfgsProdC.c
mkoctfile --mex  mcholC.c
mkoctfile --mex lbfgsC.c
mkoctfile --mex lbfgsAddC.c
cp *.mex ../compiled
rm *.mex *.o

Dalsi data je treba stahnout z http://ai.stanford.edu/~amaas/data/data.zip, patri do adresare common
Jedna se o MNIST databazi z http://yann.lecun.com/exdb/mnist/ - tam je i popis formatu

Do Netbeans existuje nasledujici plugin. Je ulozen i v projektu pod adresarem doc.
http://plugins.netbeans.org/plugin/18433/octavenb
Nastaveni je pres Tools/Options - cesta k binaru - /usr/bin/octave

