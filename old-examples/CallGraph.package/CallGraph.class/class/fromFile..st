instance creation
fromFile: fileName
  ^ self new from: (FileStream fileNamed: fileName) contents