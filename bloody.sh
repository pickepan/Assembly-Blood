RED='\033[0;31m'
NC='\033[0m' # No Color

if [ "$#" -eq 0 ]; then
	echo "USAGE: ./bloody.sh <path_to_.blood_file> [OPTIONS]"
else
	if [[ "$*" == *-debug* ]]
	then
		if [[ -e bloodyJAR.jar ]]; then
			java -jar bloodyJAR.jar $1 'yes' 'yes'
		else 
			./gradlew BLOODY -Pargs=$1 -Dargs='yes'
		fi
		
		src_file=`expr $(echo $1 |cut -f1 -d.)`
		src_end=".src"
		iup_end=".iup"
		src_file_src+=${src_file}${src_end}
		iup_file+=${src_file}${iup_end}
		java -jar jar/microPIUPK.jar -ass $src_file_src
		if ! test -f $iup_file; then
			exit 1
		fi
	else
		if [[ -e bloodyJAR.jar ]]; then
			java -jar bloodyJAR.jar $1 'no' 'yes' > /dev/null 2>/dev/null;gradle_exit_code=$?
		else 
			./gradlew BLOODY -Pargs=$1 -Dargs='no' > /dev/null 2>/dev/null;gradle_exit_code=$?
		fi
		
		if (( gradle_exit_code != 0 )); then
			echo -e "${RED}Compilation failed${NC}"
			exit 2
		fi

		src_file=`expr $(echo $1 |cut -f1 -d.)`
		src_end=".src"
		iup_end=".iup"
		src_file_src+=${src_file}${src_end}
		iup_file+=${src_file}${iup_end}
		java -jar jar/microPIUPK.jar -ass $src_file_src > /dev/null
		if ! test -f $iup_file; then
			echo -e "${RED}Assembly failed${NC}"
			exit 3
		fi
	fi

	if [[ "$*" == *-without_infos* ]]
	then
		rm output 2> /dev/null
	    touch output
		java -jar jar/microPIUPK.jar -batch $iup_file > output
		sim_posit=`expr $(grep -i -n 'Simulation' output | cut -d ":" -f1) - 1`
		head -n $sim_posit output
		rm output 2> /dev/null
	else
	    java -jar jar/microPIUPK.jar -batch $iup_file 2> /dev/null;gradle_exit_code=$?
		if (( gradle_exit_code != 0 )); then
			echo -e "${RED}Execution failed${NC}"
			exit 4
		fi
	fi
fi
