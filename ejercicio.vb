type esto
  dim a as integer
  dim b as boolean
  dim c as variant
end type

function otra(byval a as boolean) as integer
  otra = 5
end function

function esta(byval cad as string,byref i as integer) as boolean
  return true
end function

Sub main()
  dim a as variant
  dim b as variant
  dim x as integer
  dim h as boolean
  dim cual as esto
  a = 6
  b = 7 
  x = a + b + 3 + a
  a = true
  h = not a 
  if h then
    write "hola"
  end if
 
   a = true
  cual.a = x - 5
  h = esta("hola",2)
end sub
