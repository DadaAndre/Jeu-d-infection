rm -Rf build
mkdir build
javac -d build -cp src/ src/game/*.java -Xlint
java -cp build game.Main
