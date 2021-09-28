#include <stdio.h>
#include <string.h>
#include <signal.h>
int main(int argc, char*  argv[]) {

char c;
scanf("%c",&c);
if (( c >= 'a' && c <= 'z' ) || ( c >= 'A'&& c <= 'Z')) {

printf("%c = %d ",c,c);
} else {
raise(11);
}


return 0;

}