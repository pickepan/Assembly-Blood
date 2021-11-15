DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"

if [[ ${PWD##*/} == "carton14u" ]]; then
	echo online
	gradle clean
	gradle build
	$DIR/../gradlew build runAssAffectation runexempleProgrammeDebug runOpalgDebug runAppelFonctionDebug runMainDebug runifwhileDebug runClasses_1Debug runPres2_ControlesSemantiquesDebug runPres2_TDSDebug runClasses_2Debug
else
	echo local
	cd ..
	./gradlew build runAssAffectation runexempleProgrammeDebug runOpalgDebug runAppelFonctionDebug runMainDebug runifwhileDebug runClasses_1Debug runPres2_ControlesSemantiquesDebug runPres2_TDSDebug runClasses_2Debug
fi