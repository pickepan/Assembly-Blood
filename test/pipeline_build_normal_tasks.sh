DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"

if [[ ${PWD##*/} == "carton14u" ]]; then
	echo online
	gradle clean
	gradle build
	$DIR/../gradlew build runexempleProgramme runOpalg runAppelFonction runMain runifwhile runClasses_1 runPres2_ControlesSemantiques runPres2_TDS runClasses_2 runTestJoffrey semantic_control_result
else
	echo local
	cd ..
	./gradlew build runexempleProgramme runOpalg runAppelFonction runMain runifwhile runClasses_1 runPres2_ControlesSemantiques runPres2_TDS runClasses_2 runTestJoffrey semantic_control_result
fi