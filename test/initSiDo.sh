#!/bin/bash
# fichier pour lancer le simulateur SiDo avec les fichiers CMaisonUser.java et HabitatSpecific.java de notre choix
# prend en 1er argument le chemin du dossier ou se trouve SiDoInit
# prend en 2eme argument le nom du dossier (au meme niveau que SiDoInit) ou se trouvent les versions de CMaisonUser.java et HabitatSpecific.java a utiliser
# prend en 3eme argument le nom du dossier resultat (mis dans le meme dossier que SiDoInit)

SIDOIDIRPATH=$1
INDIR=$2
OUTDIR=$3

cd $SIDOIDIRPATH

echo "   "
echo "Recompilation du simulateur SiDo a partir de SiDoInit en      "$PWD
echo "   avec les fichiers CMaisonUser.java et HabitatSpecific.java de      "$INDIR
echo "   dans      "$OUTDIR

cp -R SiDoInit $OUTDIR
cp $INDIR/CMaisonUser.java $OUTDIR/src/
cp $INDIR/HabitatSpecific.java $OUTDIR/src/

echo "   "
echo "   creation et copies ok"

export CLASSPATH=$CLASSPATH:$SIDOIDIRPATH/$OUTDIR/src
javac -encoding ISO-8859-1 -d $SIDOIDIRPATH/$OUTDIR/bin $SIDOIDIRPATH/$OUTDIR/src/*.java

echo "   "
echo "   compilation ok"

cd $SIDOIDIRPATH/$OUTDIR/bin
jar cfm sido.jar ../META-INF/MANIFEST.MF *.class

echo "   "
echo "   creation jar ok"

java -jar sido.jar
