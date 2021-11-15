DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"


if [[ ${PWD##*/} == "carton14u" ]]; then
	echo online
	gradle clean
	gradle build
	$DIR/../gradlew build ASM ASM2 runAssAffectation runAssTestBoolean runAssArithmetiqueDebug runAssAriObj runTestJoffreyASM permanent_test_cast permanent_test_objet3 permanent_test_if permanent_presentation
else
	echo local
	cd ..
	./gradlew build ASM ASM2 runAssAffectation runAssTestBoolean runAssArithmetiqueDebug runAssAriObj runTestJoffreyASM permanent_test_cast permanent_test_objet3 permanent_test_if permanent_presentation
fi


java -jar $DIR/../jar/microPIUPK.jar -ass $DIR/assembly/quality_tests/ifWhile.src
if test -f $DIR/assembly/quality_tests/ifWhile.iup; then
	echo "exists Christophe test 1 : if"
else
	exit 1
fi
java -jar $DIR/../jar/microPIUPK.jar -batch $DIR/assembly/quality_tests/ifWhile.iup

java -jar $DIR/../jar/microPIUPK.jar -ass $DIR/assembly/quality_tests/ifWhile2.src
if test -f $DIR/assembly/quality_tests/ifWhile2.iup; then
	echo "exists Christophe test 2 : if 2"
else
	exit 1
fi
java -jar $DIR/../jar/microPIUPK.jar -batch $DIR/assembly/quality_tests/ifWhile2.iup

java -jar $DIR/../jar/microPIUPK.jar -ass $DIR/assembly/quality_tests/testIf.src
if test -f $DIR/assembly/quality_tests/testIf.iup; then
	echo "exists Christophe test 3 : if 3"
else
	exit 1
fi
java -jar $DIR/../jar/microPIUPK.jar -batch $DIR/assembly/quality_tests/testIf.iup

java -jar $DIR/../jar/microPIUPK.jar -ass $DIR/assembly/quality_tests/ass_affectation.src
if test -f $DIR/assembly/quality_tests/ass_affectation.iup; then
	echo "exists Assembly test"
else
	exit 1
fi
java -jar $DIR/../jar/microPIUPK.jar -batch $DIR/assembly/quality_tests/ass_affectation.iup

java -jar $DIR/../jar/microPIUPK.jar -ass $DIR/assembly/ass_testBoolean.src
if test -f $DIR/assembly/ass_testBoolean.iup; then
	echo "exists Boolean test"
else
	exit 1
fi
java -jar $DIR/../jar/microPIUPK.jar -batch $DIR/assembly/ass_testBoolean.iup


java -jar $DIR/../jar/microPIUPK.jar -ass $DIR/assembly/quality_tests/ass_arithmetique.src
if test -f $DIR/assembly/quality_tests/ass_arithmetique.iup; then
	echo "exists Matthieu"
else
	exit 1
fi
java -jar $DIR/../jar/microPIUPK.jar -batch $DIR/assembly/quality_tests/ass_arithmetique.iup

java -jar $DIR/../jar/microPIUPK.jar -ass $DIR/assembly/quality_tests/ass_ari_obj.src
if test -f $DIR/assembly/quality_tests/ass_ari_obj.iup; then
	echo "exists Matthieu 2"
else
	exit 1
fi
java -jar $DIR/../jar/microPIUPK.jar -batch $DIR/assembly/quality_tests/ass_ari_obj.iup


java -jar $DIR/../jar/microPIUPK.jar -ass $DIR/assembly/quality_tests/testObjetJoffrey.src
if test -f $DIR/assembly/quality_tests/testObjetJoffrey.iup; then
	echo "exists Joffrey"
else
	exit 1
fi
java -jar $DIR/../jar/microPIUPK.jar -batch $DIR/assembly/quality_tests/testCast.iup

java -jar $DIR/../jar/microPIUPK.jar -ass $DIR/assembly/quality_tests/testCast.src
if test -f $DIR/assembly/quality_tests/testCast.iup; then
	echo "exists Joffrey Cast"
else
	exit 1
fi
java -jar $DIR/../jar/microPIUPK.jar -batch $DIR/assembly/quality_tests/testCast.iup

java -jar $DIR/../jar/microPIUPK.jar -ass $DIR/assembly/quality_tests/testObjetJoffrey3.src
if test -f $DIR/assembly/quality_tests/testObjetJoffrey3.iup; then
	echo "exists Joffrey Objet"
else
	exit 1
fi
java -jar $DIR/../jar/microPIUPK.jar -batch $DIR/assembly/quality_tests/testObjetJoffrey3.iup

 java -jar $DIR/../jar/microPIUPK.jar -ass $DIR/assembly/quality_tests/presentation.src
 if test -f $DIR/assembly/quality_tests/presentation.iup; then
 	echo "exists presentation test"
 else
 	exit 1
 fi
 java -jar $DIR/../jar/microPIUPK.jar -batch $DIR/assembly/quality_tests/presentation.iup