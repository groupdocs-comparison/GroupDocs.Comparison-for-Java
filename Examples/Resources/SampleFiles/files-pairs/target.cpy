context.n = context.REQUEST.get('b')

# Optionally set the default next action (this can be overridden
# in the ZMI)

state.setNextAction('redirect_to:string:overview')

# Optionally pass a message to display to the user
state.setKwargs({'portal_status_message':'You get context.n to %s.' % str(context.n)})
return state