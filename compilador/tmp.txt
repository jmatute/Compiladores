type probando
  dim a as integer
  dim b as integer
end type
sub main()
  dim a as integer
  dim b as boolean
  dim c as variant
  dim d as probando
  d.b = 5
  d.a = d.b + 3 
  esta( 5*3+2 -4,true and not true or false)
end sub

function esta(byref a as integer,byval a as boolean) as integer
  dim a as integer
  dim b as boolean
  dim c as variant
  'a = -1
  'a = 5 * 3 + 3 *(5 + - 3)
  'b = true
  'b = not b
  'if 5 < 3 then
  '  c = 3
  'end if 
end function

dim y as probando
dim x as integer

