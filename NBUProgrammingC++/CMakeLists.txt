cmake_minimum_required(VERSION 3.8)
project(NBUProgramming)

set(CMAKE_CXX_STANDARD 14)

set(SOURCE_FILES main.cpp Problems/Problem1.cpp Problems/BasesConvertions.cpp Problems/BasesConverter.cpp Problems/DecimalToRome.cpp Problems/PrimeRandoms.cpp)
add_executable(NBUProgramming ${SOURCE_FILES})