#include <stdio.h>
#include <assert.h>

typedef enum {
	little_endianness,
	big_endianness
} endianness_t;


endianness_t getByteOrder() {
	int n = 1;
	char* n_p = &n;

	return (*n_p == 0) ? big_endianness : little_endianness;
}

int toBigEndianness(const int n) {
	int res = 0;
	char* res_p = (char*)&res + sizeof(n) - 1;
	char* n_p = &n;

	for (int i = 0; i < sizeof(n); i++) {
		*(res_p - i) |= *(n_p + i);
	}

	return res;
}

int main(void)
{
	printf("%s", (getByteOrder() == big_endianness) ? "big" : "little");

	return 0;
}