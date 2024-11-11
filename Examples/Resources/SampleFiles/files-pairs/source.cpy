context.n = context.REQUEST.get('n')

# Optionally set the default next action (this can be overridden
# in the ZMI)

state.setNextAction('redirect_to:string:view')

# Optionally pass a message to display to the user
state.setKwargs({'portal_status_message':'You set context.n to %s.' % str(context.n)})
return state