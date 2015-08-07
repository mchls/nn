
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

VirtualBox je sice v Suse balicich, ale asi je lepsi jej stahnout z: https://www.virtualbox.org/

Ubuntu:

apt-get install openssh-server
Nefunguje-li bridged network, staci pouzit NAT a pridat port forwarding - jen vyplnit tcp, host port 2222, guest port 22
A z hostitele dat: ssh localhost -p 2222


