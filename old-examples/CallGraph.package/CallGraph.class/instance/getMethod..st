accessing
getMethod: signature
	| fields methodName returnType argTypes |
	fields := $: split: signature.
	returnType := self getClass: (fields at: 1).
	methodName := fields at: 2.
	argTypes := (fields copyFrom: 3 to: fields size) collect: [ :each | self getClass: each ].
	^ methods
		at: signature
		ifAbsentPut: [ 
			JMethod new
				name: methodName;
				returnType: returnType;
				argTypes: argTypes ]