DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"


if [[ ${PWD##*/} == "carton14u" ]]; then
	echo online
	gradle clean
	gradle build
	$DIR/../gradlew build permanent_test_cast ASM ASM2 permanent_test_if esperluetteASM runAssArithmetiqueDebug runTestJoffreyASM permanent_test_objet2 permanent_test_objet3 runAssAffectation runAssAriObj
else
	echo local
	cd ..
	./gradlew build permanent_test_cast ASM ASM2 permanent_test_if esperluetteASM runAssArithmetiqueDebug runTestJoffreyASM permanent_test_objet2 permanent_test_objet3 runAssAffectation runAssAriObj
fi

echo "beginning permanent tests session"


java -jar $DIR/../jar/microPIUPK.jar -ass $DIR/assembly/quality_tests/testCast.src > /dev/null
if test -f $DIR/assembly/quality_tests/testCast.iup; then
	echo "exists permanent quality test 0 : cast"
else
	exit 1
fi
touch $DIR/assembly/quality_tests/testCast_
touch $DIR/assembly/quality_tests/testCast_2
java -jar $DIR/../jar/microPIUPK.jar -batch $DIR/assembly/quality_tests/testCast.iup > $DIR/assembly/quality_tests/testCast_

posit=`expr $(grep -i -n 'Etat du processeur ' $DIR/assembly/quality_tests/testCast_ | cut -d ":" -f1) - 2`
head -n $posit $DIR/assembly/quality_tests/testCast_ > $DIR/assembly/quality_tests/testCast_2

if [[ ${PWD##*/} == "carton14u" ]]; then
	echo online
	gradle clean
	gradle build
	$DIR/../gradlew build pipeline0Cast; gradle_exit_code=$?
	if (( gradle_exit_code != 0 )); then
		echo "Cast test failed"
		cat $DIR/assembly/quality_tests/testCast_2
		echo "expected :"
		cat $DIR/assembly/quality_tests/testCast_3
		exit 1
	fi
else
	echo local
	cd ..
	./gradlew build pipeline0Cast
fi



java -jar $DIR/../jar/microPIUPK.jar -ass $DIR/assembly/quality_tests/ifWhile.src > /dev/null
if test -f $DIR/assembly/quality_tests/ifWhile.iup; then
	echo "exists permanent quality test 1 : if Christophe"
else
	exit 1
fi
touch $DIR/assembly/quality_tests/ifWhile_
touch $DIR/assembly/quality_tests/ifWhile_2
java -jar $DIR/../jar/microPIUPK.jar -batch $DIR/assembly/quality_tests/ifWhile.iup > $DIR/assembly/quality_tests/ifWhile_

posit=`expr $(grep -i -n 'Etat du processeur ' $DIR/assembly/quality_tests/ifWhile_ | cut -d ":" -f1) - 2`
head -n $posit $DIR/assembly/quality_tests/ifWhile_ > $DIR/assembly/quality_tests/ifWhile_2

if [[ ${PWD##*/} == "carton14u" ]]; then
	echo online
	gradle clean
	gradle build
	$DIR/../gradlew build pipeline; gradle_exit_code=$?
	if (( gradle_exit_code != 0 )); then
		echo "If while test failed"
		cat $DIR/assembly/quality_tests/ifWhile_2
		echo "expected :"
		cat $DIR/assembly/quality_tests/ifWhile_3
		exit 1
	fi
else
	echo local
	cd ..
	./gradlew build pipeline
fi


java -jar $DIR/../jar/microPIUPK.jar -ass $DIR/assembly/quality_tests/testIf.src > /dev/null
if test -f $DIR/assembly/quality_tests/testIf.iup; then
	echo "exists permanent quality test 2 : if Joffrey"
else
	exit 1
fi
touch $DIR/assembly/quality_tests/testIf_
touch $DIR/assembly/quality_tests/testIf_2
java -jar $DIR/../jar/microPIUPK.jar -batch $DIR/assembly/quality_tests/testIf.iup > $DIR/assembly/quality_tests/testIf_

posit=`expr $(grep -i -n 'Etat du processeur ' $DIR/assembly/quality_tests/testIf_ | cut -d ":" -f1) - 2`
head -n $posit $DIR/assembly/quality_tests/testIf_ > $DIR/assembly/quality_tests/testIf_2

if [[ ${PWD##*/} == "carton14u" ]]; then
	echo online
	gradle clean
	gradle build
	$DIR/../gradlew build pipeline2; gradle_exit_code=$?
	if (( gradle_exit_code != 0 )); then
		echo "test 2 : if Joffrey failed"
		cat $DIR/assembly/quality_tests/testIf_2
		echo "expected :"
		cat $DIR/assembly/quality_tests/testIf_3
		exit 1
	fi
else
	echo local
	cd ..
	./gradlew build pipeline2
fi


java -jar $DIR/../jar/microPIUPK.jar -ass $DIR/assembly/quality_tests/esperluette.src > /dev/null
if test -f $DIR/assembly/quality_tests/esperluette.iup; then
	echo "exists permanent quality test 3 : esperluette"
else
	exit 1
fi
touch $DIR/assembly/quality_tests/esperluette_
touch $DIR/assembly/quality_tests/esperluette_2
java -jar $DIR/../jar/microPIUPK.jar -batch $DIR/assembly/quality_tests/esperluette.iup > $DIR/assembly/quality_tests/esperluette_

posit=`expr $(grep -i -n 'Etat du processeur ' $DIR/assembly/quality_tests/esperluette_ | cut -d ":" -f1) - 2`
head -n $posit $DIR/assembly/quality_tests/esperluette_ > $DIR/assembly/quality_tests/esperluette_2

if [[ ${PWD##*/} == "carton14u" ]]; then
	echo online
	gradle clean
	gradle build
	$DIR/../gradlew build pipeline3; gradle_exit_code=$?
	if (( gradle_exit_code != 0 )); then
		echo "test 3 : esperluette failed"
		cat $DIR/assembly/quality_tests/esperluette_2
		echo "expected :"
		cat $DIR/assembly/quality_tests/esperluette_3
		exit 1
	fi
else
	echo local
	cd ..
	./gradlew build pipeline3
fi


java -jar $DIR/../jar/microPIUPK.jar -ass $DIR/assembly/quality_tests/ass_arithmetique.src > /dev/null
if test -f $DIR/assembly/quality_tests/ass_arithmetique.iup; then
	echo "exists permanent quality test 4 : ass_arithmetique"
else
	exit 1
fi
touch $DIR/assembly/quality_tests/ass_arithmetique_
touch $DIR/assembly/quality_tests/ass_arithmetique_2
java -jar $DIR/../jar/microPIUPK.jar -batch $DIR/assembly/quality_tests/ass_arithmetique.iup > $DIR/assembly/quality_tests/ass_arithmetique_

posit=`expr $(grep -i -n 'Etat du processeur ' $DIR/assembly/quality_tests/ass_arithmetique_ | cut -d ":" -f1) - 2`
head -n $posit $DIR/assembly/quality_tests/ass_arithmetique_ > $DIR/assembly/quality_tests/ass_arithmetique_2

if [[ ${PWD##*/} == "carton14u" ]]; then
	echo online
	gradle clean
	gradle build
	$DIR/../gradlew build pipeline4MatthieuArithmetique; gradle_exit_code=$?
	if (( gradle_exit_code != 0 )); then
		echo "test 4 : ass_arithmetique failed"
		cat $DIR/assembly/quality_tests/ass_arithmetique_2
		echo "expected :"
		cat $DIR/assembly/quality_tests/ass_arithmetique_3
		exit 1
	fi
else
	echo local
	cd ..
	./gradlew build pipeline4MatthieuArithmetique
fi

java -jar $DIR/../jar/microPIUPK.jar -ass $DIR/assembly/quality_tests/ifWhile2.src > /dev/null
if test -f $DIR/assembly/quality_tests/ifWhile2.iup; then
	echo "exists permanent quality test 5 : ifWhile2"
else
	exit 1
fi
touch $DIR/assembly/quality_tests/ifWhile2_
touch $DIR/assembly/quality_tests/ifWhile2_2
java -jar $DIR/../jar/microPIUPK.jar -batch $DIR/assembly/quality_tests/ifWhile2.iup > $DIR/assembly/quality_tests/ifWhile2_

posit=`expr $(grep -i -n 'Etat du processeur ' $DIR/assembly/quality_tests/ifWhile2_ | cut -d ":" -f1) - 2`
head -n $posit $DIR/assembly/quality_tests/ifWhile2_ > $DIR/assembly/quality_tests/ifWhile2_2

if [[ ${PWD##*/} == "carton14u" ]]; then
	echo online
	gradle clean
	gradle build
	$DIR/../gradlew build pipeline5IfWhile2; gradle_exit_code=$?
	if (( gradle_exit_code != 0 )); then
		echo "test 5 : ifWhile2 failed"
		cat $DIR/assembly/quality_tests/ifWhile2_2
		echo "expected :"
		cat $DIR/assembly/quality_tests/ifWhile2_3
		exit 1
	fi
else
	echo local
	cd ..
	./gradlew build pipeline5IfWhile2
fi


java -jar $DIR/../jar/microPIUPK.jar -ass $DIR/assembly/quality_tests/testObjetJoffrey.src > /dev/null
if test -f $DIR/assembly/quality_tests/testObjetJoffrey.iup; then
	echo "exists permanent quality test 6 : testObjetJoffrey"
else
	exit 1
fi
touch $DIR/assembly/quality_tests/testObjetJoffrey_
touch $DIR/assembly/quality_tests/testObjetJoffrey_2
java -jar $DIR/../jar/microPIUPK.jar -batch $DIR/assembly/quality_tests/testObjetJoffrey.iup > $DIR/assembly/quality_tests/testObjetJoffrey_

posit=`expr $(grep -i -n 'Etat du processeur ' $DIR/assembly/quality_tests/testObjetJoffrey_ | cut -d ":" -f1) - 2`
head -n $posit $DIR/assembly/quality_tests/testObjetJoffrey_ > $DIR/assembly/quality_tests/testObjetJoffrey_2

if [[ ${PWD##*/} == "carton14u" ]]; then
	echo online
	gradle clean
	gradle build
	$DIR/../gradlew build pipeline6testObjetJoffrey; gradle_exit_code=$?
	if (( gradle_exit_code != 0 )); then
		echo "test 6 : testObjetJoffrey failed"
		cat $DIR/assembly/quality_tests/testObjetJoffrey_2
		echo "expected :"
		cat $DIR/assembly/quality_tests/testObjetJoffrey_3
		exit 1
	fi
else
	echo local
	cd ..
	./gradlew build pipeline6testObjetJoffrey
fi

java -jar $DIR/../jar/microPIUPK.jar -ass $DIR/assembly/quality_tests/testObjet2.src > /dev/null
if test -f $DIR/assembly/quality_tests/testObjet2.iup; then
	echo "exists permanent quality test 7 : testObjet2"
else
	exit 1
fi
touch $DIR/assembly/quality_tests/testObjet2_
touch $DIR/assembly/quality_tests/testObjet2_2
java -jar $DIR/../jar/microPIUPK.jar -batch $DIR/assembly/quality_tests/testObjet2.iup > $DIR/assembly/quality_tests/testObjet2_

posit=`expr $(grep -i -n 'Etat du processeur ' $DIR/assembly/quality_tests/testObjet2_ | cut -d ":" -f1) - 2`
head -n $posit $DIR/assembly/quality_tests/testObjet2_ > $DIR/assembly/quality_tests/testObjet2_2

if [[ ${PWD##*/} == "carton14u" ]]; then
	echo online
	gradle clean
	gradle build
	$DIR/../gradlew build pipeline7testObjet2; gradle_exit_code=$?
	if (( gradle_exit_code != 0 )); then
		echo "test 7 : testObjet2 failed"
		cat $DIR/assembly/quality_tests/testObjet2_2
		echo "expected :"
		cat $DIR/assembly/quality_tests/testObjet2_3
		exit 1
	fi
else
	echo local
	cd ..
	./gradlew build pipeline7testObjet2
fi

java -jar $DIR/../jar/microPIUPK.jar -ass $DIR/assembly/quality_tests/testObjetJoffrey3.src > /dev/null
if test -f $DIR/assembly/quality_tests/testObjetJoffrey3.iup; then
	echo "exists permanent quality test 8 : testObjetJoffrey3"
else
	exit 1
fi
touch $DIR/assembly/quality_tests/testObjetJoffrey3_
touch $DIR/assembly/quality_tests/testObjetJoffrey3_2
java -jar $DIR/../jar/microPIUPK.jar -batch $DIR/assembly/quality_tests/testObjetJoffrey3.iup > $DIR/assembly/quality_tests/testObjetJoffrey3_

posit=`expr $(grep -i -n 'Etat du processeur ' $DIR/assembly/quality_tests/testObjetJoffrey3_ | cut -d ":" -f1) - 2`
head -n $posit $DIR/assembly/quality_tests/testObjetJoffrey3_ > $DIR/assembly/quality_tests/testObjetJoffrey3_2

if [[ ${PWD##*/} == "carton14u" ]]; then
	echo online
	gradle clean
	gradle build
	$DIR/../gradlew build pipeline8testObjetJoffrey3; gradle_exit_code=$?
	if (( gradle_exit_code != 0 )); then
		echo "test 8 : testObjetJoffrey3 failed"
		cat $DIR/assembly/quality_tests/testObjetJoffrey3_2
		echo "expected :"
		cat $DIR/assembly/quality_tests/testObjetJoffrey3_3
		exit 1
	fi
else
	echo local
	cd ..
	./gradlew build pipeline8testObjetJoffrey3
fi


java -jar $DIR/../jar/microPIUPK.jar -ass $DIR/assembly/quality_tests/ass_affectation.src > /dev/null
if test -f $DIR/assembly/quality_tests/ass_affectation.iup; then
	echo "exists permanent quality test 9 : ass_affectation"
else
	exit 1
fi
touch $DIR/assembly/quality_tests/ass_affectation_
touch $DIR/assembly/quality_tests/ass_affectation_2
java -jar $DIR/../jar/microPIUPK.jar -batch $DIR/assembly/quality_tests/ass_affectation.iup > $DIR/assembly/quality_tests/ass_affectation_

posit=`expr $(grep -i -n 'Etat du processeur ' $DIR/assembly/quality_tests/ass_affectation_ | cut -d ":" -f1) - 2`
head -n $posit $DIR/assembly/quality_tests/ass_affectation_ > $DIR/assembly/quality_tests/ass_affectation_2

if [[ ${PWD##*/} == "carton14u" ]]; then
	echo online
	gradle clean
	gradle build
	$DIR/../gradlew build pipeline9ass_affectation; gradle_exit_code=$?
	if (( gradle_exit_code != 0 )); then
		echo "test 9 : ass_affectation failed"
		cat $DIR/assembly/quality_tests/ass_affectation_2
		echo "expected :"
		cat $DIR/assembly/quality_tests/ass_affectation_3
		exit 1
	fi
else
	echo local
	cd ..
	./gradlew build pipeline9ass_affectation
fi

java -jar $DIR/../jar/microPIUPK.jar -ass $DIR/assembly/quality_tests/ass_ari_obj.src > /dev/null
if test -f $DIR/assembly/quality_tests/ass_ari_obj.iup; then
	echo "exists permanent quality test 10 : ass_arithmetique_obj"
else
	exit 1
fi
touch $DIR/assembly/quality_tests/ass_ari_obj_
touch $DIR/assembly/quality_tests/ass_ari_obj_2
java -jar $DIR/../jar/microPIUPK.jar -batch $DIR/assembly/quality_tests/ass_ari_obj.iup > $DIR/assembly/quality_tests/ass_ari_obj_

posit=`expr $(grep -i -n 'Etat du processeur ' $DIR/assembly/quality_tests/ass_ari_obj_ | cut -d ":" -f1) - 2`
head -n $posit $DIR/assembly/quality_tests/ass_ari_obj_ > $DIR/assembly/quality_tests/ass_ari_obj_2

if [[ ${PWD##*/} == "carton14u" ]]; then
	echo online
	gradle clean
	gradle build
	$DIR/../gradlew build pipeline10ass_ari_obj; gradle_exit_code=$?
	if (( gradle_exit_code != 0 )); then
		echo "test 10 : ass_arithmetique_obj failed"
		cat $DIR/assembly/quality_tests/ass_ari_obj_2
		echo "expected :"
		cat $DIR/assembly/quality_tests/ass_ari_obj_2
		exit 1
	fi
else
	echo local
	cd ..
	./gradlew build pipeline10ass_ari_obj
fi